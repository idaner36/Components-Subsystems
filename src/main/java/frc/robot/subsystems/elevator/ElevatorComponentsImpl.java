package frc.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

import static frc.robot.subsystems.elevator.ElevatorConstants.ComponentsConstants.*;

public class ElevatorComponentsImpl implements ElevatorComponents {
    private WPI_TalonFX leftMasterMotor;
    private WPI_TalonFX rightMasterMotor;
    private WPI_TalonFX leftSlave1Motor;
    private WPI_TalonFX leftSlave2Motor;
    private WPI_TalonFX rightSlave1Motor;
    private WPI_TalonFX rightSlave2Motor;
    private PigeonIMU pigeonIMU;

    public ElevatorComponentsImpl() {
        leftMasterMotor = new WPI_TalonFX(LEFT_MASTER_MOTOR_PORT);
        leftMasterMotor.configFactoryDefault();

        leftSlave1Motor = new WPI_TalonFX(LEFT_SLAVE_1_MOTOR_PORT);
        leftSlave1Motor.follow(leftMasterMotor);

        leftSlave2Motor = new WPI_TalonFX(LEFT_SLAVE_2_MOTOR_PORT);
        leftSlave2Motor.follow(leftMasterMotor);

        rightMasterMotor = new WPI_TalonFX(RIGHT_MASTER_MOTOR_PORT);
        rightMasterMotor.configFactoryDefault();

        rightSlave1Motor = new WPI_TalonFX(RIGHT_SLAVE_1_MOTOR_PORT);
        rightSlave1Motor.follow(rightMasterMotor);

        rightSlave2Motor = new WPI_TalonFX(RIGHT_SLAVE_2_MOTOR_PORT);
        rightSlave2Motor.follow(rightMasterMotor);

        pigeonIMU = new PigeonIMU(PIGEON_IMU_DEV_NUM);
        pigeonIMU.configFactoryDefault();
    }

    @Override
    public MotorController getLeftMasterMotor() {
        return leftMasterMotor;
    }

    @Override
    public MotorController getRightMasterMotor() {
        return rightMasterMotor;
    }

    @Override
    public PigeonIMU getGyro() {
        return pigeonIMU;
    }
}
