package com.hp.cmcc.bboss.gprs.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FileService {

	public List<String> GetFileBody(String path) throws Exception{
		List<String> list = new LinkedList<String>();
		File f = new File(path);
		if(!f.exists() || f.isDirectory()) {
			return null;
		}
		BufferedReader in = new BufferedReader(new FileReader(f));
		try {
			String line;
			while((line = in.readLine()) != null) {
				list.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
		return list;
	}
}
