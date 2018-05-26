package utilities;

/**
 * This utility will serve as a helper for the problem data classes. 
 * Every time constraint in the submitted problem (imported as a JSON file from the WEB FORM) will have various time values and all of these
 * values have a scale associated with it, telling the program if its minutes, hours or possibly even seconds.
 * This class also helps converting and comparing different scaled values.
 * 
 * @author skner
 *
 */
public class TimeVariable {

	private enum TimeScale {millisecond, second, minute, hour}
	private double value;
	private TimeScale scale;
	
	public TimeVariable(double value, String scale)	{
		this.value = value;
		this.scale = getScaleByString(scale);
	}
	
	private TimeScale getScaleByString(String scale)	{
		switch(scale)	{
		case "ms":
			return TimeScale.millisecond;
		case "sec":
			return TimeScale.second;
		case "min":
			return TimeScale.minute;
		case "hour":
			return TimeScale.hour;
		case "millisecond":
			return TimeScale.millisecond;
		case "second":
			return TimeScale.second;
		case "minute":
			return TimeScale.minute;
		default:
			throw new IllegalArgumentException("String \"" + scale + "\" doesn't match a scale (sec, min, hour)");
		}
	}

	private void convertScale(String newScale)	{
		// Optimize this later
		TimeScale tempScale = getScaleByString(newScale);
		if(scale == TimeScale.millisecond)	{
			if(tempScale.equals(TimeScale.second))	{
				this.value/=1000; 
				this.scale = tempScale;
			}	else if(tempScale.equals(TimeScale.minute))	{
				this.value/=60000;
				this.scale = tempScale;
			}	else if(tempScale.equals(TimeScale.hour))	{
				this.value/=3600000;
				this.scale = tempScale;
			}	
		}
		if(scale == TimeScale.second)	{
			if(tempScale.equals(TimeScale.millisecond))	{
				this.value*=1000; 
				this.scale = tempScale;
			}	else if(tempScale.equals(TimeScale.minute))	{
				this.value/=60;
				this.scale = tempScale;
			}	else if(tempScale.equals(TimeScale.hour))	{
				this.value/=3600;
				this.scale = tempScale;
			}
		}
		if(scale == TimeScale.minute)	{
			if(tempScale.equals(TimeScale.millisecond))	{
				this.value*=60000;
				this.scale = tempScale;
			}	else if(tempScale.equals(TimeScale.second))	{
				this.value*=60;
				this.scale = tempScale;
			}	else if(tempScale.equals(TimeScale.hour))	{
				this.value/=60;
				this.scale = tempScale;
			}		
		}
		if(scale == TimeScale.hour)	{
			if(tempScale.equals(TimeScale.millisecond))	{
				this.value/=3600000; 
				this.scale = tempScale;
			}	else if(tempScale.equals(TimeScale.second))	{
				this.value/=3600;
				this.scale = tempScale;
			}	else if(tempScale.equals(TimeScale.minute))	{
				this.value/=60;
				this.scale = tempScale;
			}		
		}
	}
	
	public double getValue(String type) {
		String oldScale = scale.toString();
		convertScale(type);
		double convertedResult = value;
		convertScale(oldScale);
		return convertedResult;
	}

	public TimeScale getScale() {
		return scale;
	}
	
	
}
