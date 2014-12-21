package si.mougli.mobitrg.business.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;

/**
 * A utility class to aid in the creation of password digests.
 * 
 */
public class PasswordUtility
{
	@Inject
	private static Logger logger;

	public static char[] encryptPasswordSHA1(char[] password)
	{
		return encryptPassword(password, "SHA-1");
	}

	public static char[] encryptPassword(char[] password, String digestAlgorithm)
	{
		char[] sha1 = null;
		try
		{
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(password.toString().getBytes("UTF-8"));
			sha1 = byteToHex(crypt.digest());
		}
		catch (NoSuchAlgorithmException | UnsupportedEncodingException | NullPointerException e)
		{
			logger.log(Level.SEVERE, e.getMessage());
			throw new RuntimeException(e);
		}

		return sha1;
	}

	private static char[] byteToHex(final byte[] hash)
	{
		Formatter formatter = new Formatter();
		for (byte b : hash)
		{
			formatter.format("%02x", b);
		}
		char[] result = formatter.toString().toCharArray();
		formatter.close();
		return result;
	}

	public static String generateRandomHash()
	{
		return UUID.randomUUID().toString();
	}
}