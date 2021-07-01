package com.jubotech.framework.util;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

public class ConverterAmrAndMp3 {

	private static String silkv3Path="/usr/local/soft/silk-v3-decoder-master/";
	 
	/**
	 * 将amr转成mp3
	 * @param coderPath
	 * @param amrfilePath
	 */
	public static void converterDecoderMp3(String coderPath, String amrfilePath) {
		if(StringUtils.isBlank(coderPath)){
			coderPath = silkv3Path;
		}
		String decoderCmd = coderPath + "converter.sh " + amrfilePath;
		exeCmd(decoderCmd);
	}

	/**
	 * 将mp3转成amr
	 * @param coderPath
	 * @param mp3filePath
	 */
	public static void converterEncoderAmr(String coderPath, String mp3filePath) {
		if(StringUtils.isBlank(coderPath)){
			coderPath = silkv3Path;
		}
		String  encoderCmd= coderPath + "converter-encoder.sh " + mp3filePath;
		exeCmd(encoderCmd);
	}

	private static void exeCmd(String commandStr) {
		BufferedReader br = null;
		try {
			Process p = Runtime.getRuntime().exec(commandStr);
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {

		String amrfilePath = "/home/1.amr";
		String mp3filePath = "/home/3.mp3";
		String coderPath = silkv3Path;

		converterDecoderMp3(coderPath, mp3filePath);
		converterEncoderAmr(coderPath, amrfilePath);
	}

}
