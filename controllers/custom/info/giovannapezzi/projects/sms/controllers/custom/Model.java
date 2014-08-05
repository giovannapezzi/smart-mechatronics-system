package info.giovannapezzi.projects.sms.controllers.custom;

/*
 * class description
 */
public class Model
{  
	/*
	 * property description
	 */  
	private float neckPositionX;
	private float neckPositionY;
	private final float minimumNeckPositionX = 0;
	private final float maximumNeckPositionX = 0;
	private final float minimumNeckPositionY = 0;
	private final float maximumNeckPositionY = 0;
	
	private float leftShoulderPositionX;
	private float leftShoulderPositionY;
	private float leftShoulderPositionZ;
	private final float minimumLeftShoulderPositionX = 0;
	private final float maximumLeftShoulderPositionX = 0;
	private final float minimumLeftShoulderPositionY = 0;
	private final float maximumLeftShoulderPositionY = 0;
	private final float minimumLeftShoulderPositionZ = 0;
	private final float maximumLeftShoulderPositionZ = 0;
	
	private float rightShoulderPositionX;
	private float rightShoulderPositionY;
	private float rightShoulderPositionZ;
	private final float minimumRightShoulderPositionX = 0;
	private final float maximumRightShoulderPositionX = 0;
	private final float minimumRightShoulderPositionY = 0;
	private final float maximumRightShoulderPositionY = 0;
	private final float minimumRightShoulderPositionZ = 0;
	private final float maximumRightShoulderPositionZ = 0;
	
	private float leftElbowPositionX;
	private final float minimumLeftElbowPositionX = 0;
	private final float maximumLeftElbowPositionX = 0;
	
	private float rightElbowPositionX;
	private final float minimumRightElbowPositionX = 0;
	private final float maximumRightElbowPositionX = 0;
	
	private float chestPositionX;
	private float chestPositionY;
	private float chestPositionZ;
	private final float minimumChestPositionX = 0;
	private final float maximumChestPositionX = 0;
	private final float minimumChestPositionY = 0;
	private final float maximumChestPositionY = 0;
	private final float minimumChestPositionZ = 0;
	private final float maximumChestPositionZ = 0;
		
	private float leftHipPositionX;
	private float leftHipPositionY;
	private float leftHipPositionZ;
	private final float minimumLeftHipPositionX = 0;
	private final float maximumLeftHipPositionX = 0;
	private final float minimumLeftHipPositionY = 0;
	private final float maximumLeftHipPositionY = 0;
	private final float minimumLeftHipPositionZ = 0;
	private final float maximumLeftHipPositionZ = 0;
	
	private float rightHipPositionX;
	private float rightHipPositionY;
	private float rightHipPositionZ;
	private final float minimumRightHipPositionX = 0;
	private final float maximumRightHipPositionX = 0;
	private final float minimumRightHipPositionY = 0;
	private final float maximumRightHipPositionY = 0;
	private final float minimumRightHipPositionZ = 0;
	private final float maximumRightHipPositionZ = 0;
	
	
	private float leftKneePositionX;
	private final float minimumLeftKneePositionX = 0;
	private final float maximumLeftKneePositionX = 0;
	
	private float rightKneePositionX;
	private final float minimumRightKneePositionX = 0;
	private final float maximumRightKneePositionX = 0;
	
	private float leftAnklePositionX;
	private float leftAnklePositionY;
	private float leftAnklePositionZ;
	private final float minimumLeftAnklePositionX = 0;
	private final float maximumLeftAnklePositionX = 0;
	private final float minimumLeftAnklePositionY = 0;
	private final float maximumLeftAnklePositionY = 0;
	private final float minimumLeftAnklePositionZ = 0;
	private final float maximumLeftAnklePositionZ = 0;
	
	private float rightAnklePositionX;
	private float rightAnklePositionY;
	private float rightAnklePositionZ;
	private final float minimumRightAnklePositionX = 0;
	private final float maximumRightAnklePositionX = 0;
	private final float minimumRightAnklePositionY = 0;
	private final float maximumRightAnklePositionY = 0;
	private final float minimumRightAnklePositionZ = 0;
	private final float maximumRightAnklePositionZ = 0;
	
	private float leftFootPositionX;
	private final float minimumLeftFootPositionX = 0;
	private final float maximumLeftFootPositionX = 0;
	
	private float rightFootPositionX;
	private final float minimumRightFootPositionX = 0;
	private final float maximumRightFootPositionX = 0;
	
	/*
	 * method description
	 */ 	
	public Model() 
	{
	
	}
	
	/*
	 * NECK X
	 * method description
	 */ 	
	public void setNeckPositionX(float position)
	{
		if (position >= this.minimumNeckPositionX && position <= this.maximumNeckPositionX)
		{
			this.neckPositionX = position;
		}
	}
	
	/*
	 * NECK X
	 * method description
	 */ 	
	public float getNeckPositionX()
	{
		return this.neckPositionX;
	}

    /*
	 * NECK Y
	 * method description
	 */ 	
	public void setNeckPositionY(float position)
	{
		if (position >= this.minimumNeckPositionY && position <= this.maximumNeckPositionY)
		{
			this.neckPositionY = position;
		}
	}
	
	/*
	 * NECK Y
	 * method description
	 */
	public float getNeckPositionY()
	{
		return this.neckPositionY;
	}
	
	/*
	 * LEFT SHOULDER X
	 * method description
	 */
	public void setLeftShoulderPositionX(float position)
	{
		if (position >= this.minimumLeftShoulderPositionX && position <= this.maximumLeftShoulderPositionX)
		{
			this.leftShoulderPositionX = position;
		}
	}
	
	/*
	 * LEFT SHOULDER X
	 * method description
	 */
	public float getLeftShoulderPositionX()
	{
		return this.leftShoulderPositionX;
	}
	
	/*
	 * LEFT SHOULDER Y
	 * method description
	 */
	public void setLeftShoulderPositionY(float position)
	{
		if (position >= this.minimumLeftShoulderPositionY && position <= this.maximumLeftShoulderPositionY)
		{
			this.leftShoulderPositionY = position;
		}
	}
	
	/*
	 * LEFT SHOULDER Y
	 * method description
	 */
	public float getLeftShoulderPositionY()
	{
		return this.leftShoulderPositionY;
	}
		 
	/*
	 * LEFT SHOULDER Z
	 * method description
	 */
	public void setLeftShoulderPositionZ(float position)
	{
		if (position >= this.minimumLeftShoulderPositionZ && position <= this.maximumLeftShoulderPositionZ)
		{
			this.leftShoulderPositionZ = position;
		}
	}
	
	/*
	 * LEFT SHOULDER Z
	 * method description
	 */
	public float getLeftShoulderPositionZ()
	{
		return this.leftShoulderPositionZ;
	}
	
	/*
	 * RIGHT SHOULDER X
	 * method description
	 */
	public void setRightShoulderPositionX(float position)
	{
		if (position >= this.minimumRightShoulderPositionX && position <= this.maximumRightShoulderPositionX)
		{
			this.rightShoulderPositionX = position;
		}
	}
	
	/*
	 * RIGHT SHOULDER X
	 * method description
	 */
	public float getRightShoulderPositionX()
	{
		return this.rightShoulderPositionX;
	}
	
	/*
	 * RIGHT SHOULDER Y
	 * method description
	 */
	public void setRightShoulderPositionY(float position)
	{
		if (position >= this.minimumRightShoulderPositionY && position <= this.maximumRightShoulderPositionY)
		{
			this.rightShoulderPositionY = position;
		}
	}
	
	/*
	 * RIGHT SHOULDER Y
	 * method description
	 */
	public float getRightShoulderPositionY()
	{
		return this.rightShoulderPositionY;
	}
	 
	/*
	 * RIGHT SHOULDER Z
	 * method description
	 */
	public void setRightShoulderPositionZ(float position)
	{
		if (position >= this.minimumRightShoulderPositionZ && position <= this.maximumRightShoulderPositionZ)
		{
			this.rightShoulderPositionZ = position;
		}
	}
	
	/*
	 * RIGHT SHOULDER Z
	 * method description
	 */
	public float getRightShoulderPositionZ()
	{
		return this.rightShoulderPositionZ;
	}
	
	/*
	 *  LEFT ELBOW X
	 * method description
	 */ 	
	public void setLeftElbowPositionX(float position)
	{
		if (position >= this.minimumLeftElbowPositionX && position <= this.maximumLeftElbowPositionX)
		{
			this.leftElbowPositionX = position;
		}
	}
	
	/*
	 * LEFT ELBOW X
	 * method description
	 */ 	
	public float getLeftElbowPositionX()
	{
		return this.leftElbowPositionX;
	}
	
	/*
	 * RIGHT ELBOW X
	 * method description
	 */ 	
	public void setRightElbowPositionX(float position)
	{
		if (position >= this.minimumRightElbowPositionX && position <= this.maximumRightElbowPositionX)
		{
			this.rightElbowPositionX = position;
		}
	}
	
	/*
	 * RIGHT ELBOW X
	 * method description
	 */ 	
	public float getRightElbowPositionX()
	{
		return this.rightElbowPositionX;
	}
	
	/*
	 * CHEST X
	 * method description
	 */
	public void setChestPositionX(float position)
	{
		if (position >= this.minimumChestPositionX && position <= this.maximumChestPositionX)
		{
			this.chestPositionX = position;
		}
	}
	
	/*
	 * CHEST X
	 * method description
	 */
	public float getChestPositionX()
	{
		return this.chestPositionX;
	}
	
	/*
	 * CHEST Y
	 * method description
	 */
	public void setChestPositionY(float position)
	{
		if (position >= this.minimumChestPositionY && position <= this.maximumChestPositionX)
		{
			this.chestPositionY = position;
		}
	}
	
	/*
	 * CHEST Y
	 * method description
	 */
	public float getChestPositionY()
	{
		return this.chestPositionY;
	}
	
	/*
	 * CHEST Z
	 * method description
	 */
	public void setChestPositionZ(float position)
	{
		if (position >= this.minimumChestPositionZ && position <= this.maximumChestPositionZ)
		{
			this.chestPositionZ = position;
		}
	}
	
	/*
	 * CHEST Z
	 * method description
	 */
	public float getChestPositionZ()
	{
		return this.chestPositionZ;
	}
	
	/*
	 * LEFT HIP X
	 * method description
	 */
	public void setLeftHipPositionX(float position)
	{
		if (position >= this.minimumLeftHipPositionX && position <= this.maximumLeftHipPositionX)
		{
			this.leftHipPositionX = position;
		}
	}
	
	/*
	 * LEFT HIP X
	 * method description
	 */
	public float getLeftHipPositionX()
	{
		return this.leftHipPositionX;
	}
	
	/*
	 * LEFT HIP Y
	 * method description
	 */
	public void setLeftHipPositionY(float position)
	{
		if (position >= this.minimumLeftHipPositionY && position <= this.maximumLeftHipPositionY)
		{
			this.leftHipPositionY = position;
		}
	}
	
	/*
	 * LEFT HIP Y
	 * method description
	 */
	public float getLeftHipPositionY()
	{
		return this.leftHipPositionY;
	}
	
	/*
	 * LEFT HIP Z
	 * method description
	 */
	public void setLeftHipPositionZ(float position)
	{
		if (position >= this.minimumLeftHipPositionZ && position <= this.maximumLeftHipPositionZ)
		{
			this.leftHipPositionZ = position;
		}
	}
	
	/*
	 * LEFT HIP Z
	 * method description
	 */
	public float getLeftHipPositionZ()
	{
		return this.leftHipPositionZ;
	}
	
	/*
	 * RIGHT HIP X
	 * method description
	 */
	public void setRightHipPositionX(float position)
	{
		if (position >= this.minimumRightHipPositionX && position <= this.maximumRightHipPositionX)
		{
			this.rightHipPositionX = position;
		}
	}
	
	/*
	 * RIGHT HIP X
	 * method description
	 */
	public float getRightHipPositionX()
	{
		return this.rightHipPositionX;
	}
	
	/*
	 * RIGHT HIP Y
	 * method description
	 */
	public void setRightHipPositionY(float position)
	{
		if (position >= this.minimumRightHipPositionY && position <= this.maximumRightHipPositionY)
		{
			this.rightHipPositionY = position;
		}
	}
	
	/*
	 * RIGHT HIP Y
	 * method description
	 */
	public float getRightHipPositionY()
	{
		return this.rightHipPositionY;
	}
	
	/*
	 * RIGHT HIP Z
	 * method description
	 */
	public void setRightHipPositionZ(float position)
	{
		if (position >= this.minimumRightHipPositionZ && position <= this.maximumRightHipPositionZ)
		{
			this.rightHipPositionZ = position;
		}
	}
	
	/*
	 * RIGHT HIP Z
	 * method description
	 */
	public float getRightHipPositionZ()
	{
		return this.rightHipPositionZ;
	}
	
	/*
	 * LEFT KNEE X
	 * method description
	 */
	public void setLeftKneePositionX(float position)
	{
		if (position >= this.minimumLeftKneePositionX && position <= this.maximumLeftKneePositionX)
		{
			this.leftKneePositionX = position;
		}
	}
	
	/*
	 * LEFT KNEE X
	 * method description
	 */
	public float getLeftKneePositionX()
	{
		return this.leftKneePositionX;
	}
	
	/*
	 * RIGHT KNEE X
	 * method description
	 */
	public void setRightKneePositionX(float position)
	{
		if (position >= this.minimumRightKneePositionX && position <= this.maximumRightKneePositionX)
		{
			this.rightKneePositionX = position;
		}
	}
	
	/*
	 * RIGHT KNEE X
	 * method description
	 */
	public float getRightKneePositionX()
	{
		return this.rightKneePositionX;
	}
	
	/*
	 * LEFT ANKLE X
	 * method description
	 */
	public void setLeftAnklePositionX(float position)
	{
		if (position >= this.minimumLeftAnklePositionX && position <= this.maximumLeftAnklePositionX)
		{
			this.leftAnklePositionX = position;
		}
	}
	
	/*
	 * LEFT ANKLE X
	 * method description
	 */
	public float getLeftAnklePositionX()
	{
		return this.leftAnklePositionX;
	}
	
	/*
	 * LEFT ANKLE Y
	 * method description
	 */
	public void setLeftAnklePositionY(float position)
	{
		if (position >= this.minimumLeftAnklePositionY && position <= this.maximumLeftAnklePositionY)
		{
			this.leftAnklePositionY = position;
		}
	}
	
	/*
	 * LEFT ANKLE Y
	 * method description
	 */
	public float getLeftAnklePositionY()
	{
		return this.leftAnklePositionY;
	}
	
	/*
	 * LEFT ANKLE Z
	 * method description
	 */
	public void setLeftAnklePositionZ(float position)
	{
		if (position >= this.minimumLeftAnklePositionZ && position <= this.maximumLeftAnklePositionZ)
		{
			this.leftAnklePositionZ = position;
		}
	}
	
	/*
	 * LEFT ANKLE Z
	 * method description
	 */
	public float getLeftAnklePositionZ()
	{
		return this.leftAnklePositionZ;
	}
	
	/*
	 * RIGHT ANKLE X
	 * method description
	 */
	public void setRightAnklePositionX(float position)
	{
		if (position >= this.minimumRightAnklePositionX && position <= this.maximumRightAnklePositionX)
		{
			this.rightAnklePositionX = position;
		}
	}
	
	/*
	 * RIGHT ANKLE X
	 * method description
	 */
	public float getRightAnklePositionX()
	{
		return this.rightAnklePositionX;
	}
	
	/*
	 * RIGHT ANKLE Y
	 * method description
	 */
	public void setRightAnklePositionY(float position)
	{
		if (position >= this.minimumRightAnklePositionY && position <= this.maximumRightAnklePositionY)
		{
			this.rightAnklePositionY = position;
		}
	}
	
	/*
	 * RIGHT ANKLE Y
	 * method description
	 */
	public float getRightAnklePositionY()
	{
		return this.rightAnklePositionY;
	}
	
	/*
	 * RIGHT ANKLE Z
	 * method description
	 */
	public void setRightAnklePositionZ(float position)
	{
		if (position >= this.minimumRightAnklePositionZ && position <= this.maximumRightAnklePositionZ)
		{
			this.rightAnklePositionZ = position;
		}
	}
	
	/*
	 * RIGHT ANKLE Z
	 * method description
	 */
	public float getRightAnklePositionZ()
	{
		return this.rightAnklePositionZ;
	}
	
	/*
	 * LEFT FOOT X
	 * method description
	 */
	public void setLeftFootPositionX(float position)
	{
		if (position >= this.minimumLeftFootPositionX && position <= this.maximumLeftFootPositionX)
		{
			this.leftFootPositionX = position;
		}
	}
	
	/*
	 * LEFT FOOT X
	 * method description
	 */
	public float getLeftFootPositionX()
	{
		return this.leftFootPositionX;
	}
	
	/*
	 * RIGHT FOOT X
	 * method description
	 */
	public void setRightFootPositionX(float position)
	{
		if (position >= this.minimumRightFootPositionX && position <= this.maximumRightFootPositionX)
		{
			this.rightFootPositionX = position;
		}
	}
	
	/*
	 * RIGHT FOOT X
	 * method description
	 */
	public float getRightFootPositionX()
	{
		return this.rightFootPositionX;
	}
	
	public void doAstep()
	{
	}
}