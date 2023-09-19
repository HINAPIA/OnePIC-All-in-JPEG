package com.goldenratio.onepic

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.documentfile.provider.DocumentFile
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.goldenratio.onepic.AllinJPEGModule.AiLoadResolver
import com.goldenratio.onepic.PictureModule.AiContainer
import com.goldenratio.onepicdiary.DiaryModule.DiaryCellData
import kotlinx.coroutines.*
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream


class JpegViewModel(private val context:Context) : ViewModel() {


    var jpegMCContainer = MutableLiveData<AiContainer>()

    var diaryCellArrayList = arrayListOf<DiaryCellData>()

    var daysInMonth: Int = 0
    var currentUri : Uri? = null

    var currentMonth: Int = 0
    var currentDay: Int = 0
    var selectMonth: Int = 0
    var selectDay: Int = 0

    var preferences: SharedPreferences =
        context.getSharedPreferences("image_file_path", Context.MODE_PRIVATE)

    var isAddedAudio = MutableLiveData<Boolean>(false)
    var isAudioPlay = MutableLiveData<Int>(0)

    private var loadResolver : AiLoadResolver = AiLoadResolver()

    private lateinit var pictureByteArrayList: MutableList<ByteArray> // pictureByteArrayList

    fun setpictureByteArrList(byteArrayList: MutableList<ByteArray>) {
        pictureByteArrayList = byteArrayList
    }

    fun getPictureByteArrList(): MutableList<ByteArray> {
        return pictureByteArrayList
    }

    fun setContainer(aiContainer: AiContainer) {
        jpegMCContainer.value = aiContainer
    }


    /** MCContainer 변경 */
    @RequiresApi(Build.VERSION_CODES.Q)
    fun setCurrentMCContainer(uri: Uri) {
        CoroutineScope(Dispatchers.IO).launch {
            val iStream: InputStream? = context.contentResolver.openInputStream(uri)
            var sourceByteArray = getBytes(iStream!!)
            var jop = async {
                loadResolver.createAiContainer(jpegMCContainer.value!!, sourceByteArray)

            }
            jop.await()
        }
    }

    @Throws(IOException::class)
    fun getBytes(inputStream: InputStream): ByteArray {
        val byteBuffer = ByteArrayOutputStream()
        val bufferSize = 1024
        val buffer = ByteArray(bufferSize)
        var len = 0
        while (inputStream.read(buffer).also { len = it } != -1) {
            byteBuffer.write(buffer, 0, len)
        }
        byteBuffer.close()
        inputStream.close()
        return byteBuffer.toByteArray()
    }

    fun getFileNameFromUri(uri: Uri): String {
        val documentFile = DocumentFile.fromSingleUri(context, uri)
        return documentFile?.name!!
    }
}