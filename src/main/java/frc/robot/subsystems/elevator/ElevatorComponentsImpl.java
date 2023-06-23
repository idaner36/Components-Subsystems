package frc.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
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
        leftMasterMotor.configAllSettings(getFalconConfiguration());
        leftMasterMotor.setNeutralMode(NeutralMode.Brake);

        leftSlave1Motor = new WPI_TalonFX(LEFT_SLAVE_1_MOTOR_PORT);
        leftSlave1Motor.follow(leftMasterMotor);
        leftSlave1Motor.configAllSettings(getFalconConfiguration());
        leftSlave1Motor.setInverted(true);

        leftSlave2Motor = new WPI_TalonFX(LEFT_SLAVE_2_MOTOR_PORT);
        leftSlave2Motor.follow(leftMasterMotor);
        leftSlave2Motor.configAllSettings(getFalconConfiguration());
        leftSlave2Motor.setInverted(true);

        rightMasterMotor = new WPI_TalonFX(RIGHT_MASTER_MOTOR_PORT);
        rightMasterMotor.configFactoryDefault();
        rightMasterMotor.configAllSettings(getFalconConfiguration());
        rightMasterMotor.setNeutralMode(NeutralMode.Brake);

        rightSlave1Motor = new WPI_TalonFX(RIGHT_SLAVE_1_MOTOR_PORT);
        rightSlave1Motor.follow(rightMasterMotor);
        rightSlave1Motor.configAllSettings(getFalconConfiguration());
        rightSlave1Motor.setInverted(true);

        rightSlave2Motor = new WPI_TalonFX(RIGHT_SLAVE_2_MOTOR_PORT);
        rightSlave2Motor.follow(rightMasterMotor);
        rightSlave2Motor.configAllSettings(getFalconConfiguration());
        rightSlave2Motor.setInverted(true);

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

    private TalonFXConfiguration getFalconConfiguration() {
        final TalonFXConfiguration config = new TalonFXConfiguration();
        config.peakOutputForward = PEAK_OUTPUT_FORWARD;
        config.peakOutputReverse = PEAK_OUTPUT_REVERSE;
        config.openloopRamp = OPEN_LOOP_RAMP;
        return config;
    }
}
