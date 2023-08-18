package com.goldenratio.onepic.PictureModule

import java.nio.ByteBuffer

class Header(_MC_container : AiContainer) {

    var headerDataLength = 0

    private var AiContainer : AiContainer
    lateinit var imageContentInfo : ImageContentInfo
    lateinit var audioContentInfo : AudioContentInfo
    lateinit var textContentInfo: TextContentInfo

    init {
        AiContainer =_MC_container
    }

    // MC Container에 채워진 Content의 정보를 Info 클래스들로 생성
    fun settingHeaderInfo(){
        imageContentInfo = ImageContentInfo(AiContainer.imageContent)
        textContentInfo = TextContentInfo(AiContainer.textContent)
        audioContentInfo = AudioContentInfo(AiContainer.audioContent,imageContentInfo.getEndOffset()+3)
        headerDataLength = getAPP3FieldLength()

        applyAddedSize()

    }
    //추가한 APP3 extension + JpegMeta data 만큼 offset 변경
    fun applyAddedSize(){
        // 추가할 APP3 extension 만큼 offset 변경 - APP3 marker(2) + APP3 Data field length + EOI
        var headerLength = 2 + getAPP3FieldLength()
        var jpegMetaLength = AiContainer.getJpegMetaBytes().size
        for(i in 0..imageContentInfo.imageCount-1){
            var pictureInfo = imageContentInfo.imageInfoList.get(i)
            if(i == 0){
                pictureInfo.dataSize += (headerLength+jpegMetaLength) + 3
            }else{
                pictureInfo.offset += (headerLength+jpegMetaLength) + 2
            }
        }
        audioContentInfo.dataStartOffset += (headerLength+jpegMetaLength)
        //textContentInfo.dataStartOffset += (headerLength+jpegMetaLength)
    }
    fun getAPP3FieldLength(): Int{
        var size = 0
        size += imageContentInfo.getLength()
        size += textContentInfo.getLength()
        size += audioContentInfo.getLength()
        return size + 8
    }
    fun convertBinaryData() : ByteArray {
        val buffer: ByteBuffer = ByteBuffer.allocate(getAPP3FieldLength() + 2)
        buffer.put("ff".toInt(16).toByte())
        buffer.put("e3".toInt(16).toByte())
        buffer.putInt(headerDataLength)
        // M, C, F, 0
        buffer.put(0x4D.toByte())
        buffer.put(0x43.toByte())
        buffer.put(0x46.toByte())
        buffer.put(0x00.toByte())
        buffer.put(imageContentInfo.converBinaryData())
        buffer.put(textContentInfo.converBinaryData())
        buffer.put(audioContentInfo.converBinaryData())
        return buffer.array()
    }
    //헤더의 내용을 바이너리 데이터로 변환하는 함수
//    fun convertBinaryData(): ByteArray{
//         var bufferSize  = pictureInfoList?.size!! * INFO_SIZE +6
//        //App3 마커
//        val buffer: ByteBuffer = ByteBuffer.allocate(bufferSize)
//        buffer.put("ff".toInt(16).toByte())
//        buffer.put("e3".toInt(16).toByte())
//        // 리스트 개수
//        buffer.putInt(pictureInfoList?.size!!)
//        //infoList
//        for(i in 0..(pictureInfoList?.size?.minus(1) ?:1 )){
//            var pictureInfo = pictureInfoList?.get(i)
//            buffer.putInt(pictureInfo!!.groupID!!)
//            buffer.putInt(pictureInfo!!.typeCode!!)
//            //작성한 APP3의 크기만큼 데이터 변경. 이 작업을 여기서 해도 괜찮은지 의논 필요
//            if(i == 0){
//                buffer.putInt(pictureInfo!!.offset!!)
//                buffer.putInt(pictureInfo!!.size!! + (bufferSize))
//
//            }else{
//                buffer.putInt(pictureInfo!!.offset!!+bufferSize-1)
//                buffer.putInt(pictureInfo!!.size!!)
//            }
//        }
//        val byteArray = buffer.array()
//        return byteArray
//    }
}