package com.jubotech.framework.netty.utils;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.protobuf.ByteString;

public class ByteStringToString {
	public static String bytesToString(ByteString src, String charSet) {
		if (StringUtils.isEmpty(charSet)) {
			charSet = "GB2312";
		}
		return bytesToString(src.toByteArray(), charSet);
	}

	private static String bytesToString(byte[] input, String charSet) {
		if (ArrayUtils.isEmpty(input)) {
			return StringUtils.EMPTY;
		}

		ByteBuffer buffer = ByteBuffer.allocate(input.length);
		buffer.put(input);
		buffer.flip();

		Charset charset = null;
		CharsetDecoder decoder = null;
		CharBuffer charBuffer = null;

		try {
			charset = Charset.forName(charSet);
			decoder = charset.newDecoder();
			charBuffer = decoder.decode(buffer.asReadOnlyBuffer());

			return charBuffer.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
