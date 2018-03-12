import java.math.BigInteger;

import org.neo.smartcontract.framework.Helper;
import org.neo.smartcontract.framework.SmartContract;
import org.neo.smartcontract.framework.services.neo.Storage;


public class Ex1 extends SmartContract {
	
	public static Object Main(String args)
	{
		if(args=="start")
			return st();
		if(args=="add")
			return add();
		return true;
	}

	private static int add() {
		BigInteger n=Helper.asBigInteger(Storage.get(Storage.currentContext(),"number"));
		n=n.add(BigInteger.ONE);
		Storage.put(Storage.currentContext(), "number", n);
		return n.intValue();
		
	}

	private static boolean st() {
		Storage.put(Storage.currentContext(), "number", BigInteger.ONE);
		return true;
	}
	
}
