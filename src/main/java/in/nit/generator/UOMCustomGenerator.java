package in.nit.generator;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UOMCustomGenerator implements IdentifierGenerator{
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix = "UOM-";
		String dt = new SimpleDateFormat("ddMMyyyy").format(new Date());
		int suffix = new Random().nextInt(5454545);
		return prefix+dt+"-"+suffix;
	}
}
