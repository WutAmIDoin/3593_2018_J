package org.usfirst.frc.team3593.robot;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;


public class GyroPIDSource implements PIDSource
{
	public double gyroAngle;	

	@Override
	public void setPIDSourceType(PIDSourceType pidSource)
	{
		// TODO Auto-generated method stub
	}


	@Override
	public PIDSourceType getPIDSourceType()
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public double pidGet()
	{
		// TODO Auto-generated method stub
		return gyroAngle;
	}
}