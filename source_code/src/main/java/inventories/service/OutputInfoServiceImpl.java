package inventories.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import inventories.model.Input;
import inventories.model.OutputInfo;
import inventories.repository.OutputInfoRepository;

@Service
public class OutputInfoServiceImpl implements OutputInfoService{
		
	@Autowired
	OutputInfoRepository outputInfoRepository;
	
	@Override
	public void create(OutputInfo outputInfo) {
		outputInfoRepository.insert(outputInfo);
		
	}

	@Override
	public void update(OutputInfo outputInfo) {
		outputInfoRepository.save(outputInfo);
		
	}

	@Override
	public void delete(OutputInfo outputInfo) {
		outputInfoRepository.delete(outputInfo);
		
	}

	@Override
	public void deleteAll() {
		outputInfoRepository.deleteAll();
		
	}

	@Override
	public OutputInfo find(OutputInfo outputInfo) {
		return outputInfoRepository.findById(outputInfo.getId()).orElse(null);
	}

	@Override
	public OutputInfo findByName(String name) {
		return outputInfoRepository.findByName(name);
	}

	@Override
	public List<OutputInfo> findAll() {
		return outputInfoRepository.findAll();
	}

	@Override
	public OutputInfo find(String id) {
		return outputInfoRepository.findById(id).orElse(null);
	}

	@Override
	public boolean checkIdExist(String id) {
		if (outputInfoRepository.existsById(id)) {
			return true;
		} 
		return false;
	}
	
	@Override
	public byte[] generateQRCodeImage(String id) throws WriterException, IOException {
		OutputInfo outputInfo = outputInfoRepository.findById(id).orElse(null);
		List<Input> inputs = outputInfo.getInput();
		double sumMoney = 0;
		double sumCount = 0;
		for(Input input :inputs) {
			sumCount = sumCount + input.getCount();
			sumMoney = sumMoney + input.getOutputPrice()*input.getCount();
		}
		
		String text = "PHIEU XUAT " + outputInfo.getId() + " DUOC XUAT VAO NGAY: " + outputInfo.getDate() + " GOM " + sumCount + " KG VA BAN DUOC " + sumMoney + "VND";
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 100, 100);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }


}
