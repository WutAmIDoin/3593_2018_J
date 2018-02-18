package org.usfirst.frc.team3593.robot;

import edu.wpi.first.wpilibj.*;

public class EncoderPIDSource implements PIDSource

{
	public double[] encoderDistances;

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

		return encoderDistances[0] - encoderDistances[1];

	}



}
