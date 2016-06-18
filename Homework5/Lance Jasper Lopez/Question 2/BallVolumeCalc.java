import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 
 * @author lopezla
 * 
 */

// Answer for #2 in W1D5 Homework
public class BallVolumeCalc {

	public static void main(String[] args){
		BigDecimal sampRadius = new BigDecimal(7.6);
		BigDecimal resultVol = new BigDecimal(0);
		
		resultVol = getBallVolume(sampRadius);
	
		DecimalFormat df = new DecimalFormat("####0.0000000000000000");
		
		System.out.println("Ball Radius: " + df.format(sampRadius));
		System.out.println("Volume: "+ df.format(resultVol));
	}
	
	public static BigDecimal getBallVolume(BigDecimal radius){
		final BigDecimal PI_CONSTANT = new BigDecimal(3.14159265359);
		BigDecimal volume = new BigDecimal(1);
		volume = volume.multiply(PI_CONSTANT.multiply(radius.pow(3)));
		
		return volume;
	}
}
