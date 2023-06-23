package frc.robot.subsystems.driveTrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public class DriveTrainComponentsImpl implements DriveTrainComponents {
    private final WPI_TalonFX leftMotor;
    private final WPI_TalonFX rightMotor;
    private final DifferentialDrive differentialDrive;

    public DriveTrainComponentsImpl() {
        leftMotor = new WPI_TalonFX(DriveTrainConstants.ComponentsConstants.LEFT_MOTOR_PORT);
        leftMotor.configFactoryDefault();

        rightMotor = new WPI_TalonFX(DriveTrainConstants.ComponentsConstants.RIGHT_MOTOR_PORT);
        rightMotor.configFactoryDefault();

        differentialDrive = new DifferentialDrive(leftMotor, rightMotor);
        differentialDrive.setSafetyEnabled(true);
    }

    @Override
    public MotorController getLeftMotor() {
        return leftMotor;
    }

    @Override
    public MotorController getRightMotor() {
        return rightMotor;
    }

    @Override
    public DifferentialDrive getDifferentialDrive() {
        return differentialDrive;
    }
}
