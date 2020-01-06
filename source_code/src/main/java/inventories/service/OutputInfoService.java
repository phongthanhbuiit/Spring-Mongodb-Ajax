package inventories.service;

import java.io.IOException;
import java.util.List;

import com.google.zxing.WriterException;

import inventories.model.OutputInfo;

public interface OutputInfoService {
	
	public void create(OutputInfo outputInfo);

	public void update(OutputInfo outputInfo);

	public void delete(OutputInfo outputInfo);

	public void deleteAll();

	public OutputInfo find(OutputInfo outputInfo);

	public OutputInfo findByName(String name);

	public List<OutputInfo> findAll();

	public OutputInfo find(String id);

	public boolean checkIdExist(String id);
	

	public byte[] generateQRCodeImage(String id) throws WriterException, IOException;
}
