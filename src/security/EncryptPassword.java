package security;

import java.security.MessageDigest;

public class EncryptPassword {

	public String encrypt(String password) {
		String algorithm = "SHA";
		byte[] plainText = password.getBytes();
		StringBuilder builder = new StringBuilder();

		try {
			MessageDigest digest = MessageDigest.getInstance(algorithm);
			digest.reset();
			digest.update(plainText);
			byte[] encodedPassword = digest.digest();

			for (byte b : encodedPassword) {
				if ((b & 0xff) < 0x10) {
					builder.append("0");
				}
				builder.append(Long.toString(b & 0xff, 16));
			}

			System.out.println("Plain    : " + password);
			System.out.println("Encrypted: " + builder.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
}
