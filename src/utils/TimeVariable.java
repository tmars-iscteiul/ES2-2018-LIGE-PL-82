package utils;

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

	private enum TimeScale {second, minute, hour}
	private float value;
	private TimeScale scale;
	
	public TimeVariable(float value, String scale)	{
		this.value = value;
		this.scale = getScaleByString(scale);
	}
	
	private TimeScale getScaleByString(String scale)	{
		if(scale == "sec")
			return TimeScale.second;
		else if(scale == "min")
			return TimeScale.minute;
		else if(scale == "hour")
			return TimeScale.hour;
		throw new IllegalArgumentException("String \"" + scale + "\" doesn't match a scale (sec, min, hour)");
	}

	private void convertScale(String newScale)	{
		// Optimize this later
		TimeScale tempScale = getScaleByString(newScale);
		if(scale == TimeScale.second)	{
			if(tempScale.equals(TimeScale.minute))	{
				this.value*=60; 
				this.scale = tempScale;
			}	else if(tempScale.equals(TimeScale.hour))	{
				this.value*=120;
				this.scale = tempScale;
			}		
		}
		if(scale == TimeScale.minute)	{
			if(tempScale.equals(TimeScale.second))	{
				this.value/=60; 
				this.scale = tempScale;
			}	else if(tempScale.equals(TimeScale.hour))	{
				this.value*=60;
				this.scale = tempScale;
			}		
		}
		if(scale == TimeScale.hour)	{
			if(tempScale.equals(TimeScale.minute))	{
				this.value/=60; 
				this.scale = tempScale;
			}	else if(tempScale.equals(TimeScale.second))	{
				this.value/=120;
				this.scale = tempScale;
			}		
		}
	}
	
	public float getValue() {
		return value;
	}

	public TimeScale getScale() {
		return scale;
	}
	
	
}
