package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

/**
 * A subsystem that uses the {@link SampleMecanumDrive} class.
 */
public class MecanumDriveSubsystem extends SubsystemBase {

    private final SampleMecanumDrive drive;

    public MecanumDriveSubsystem(SampleMecanumDrive drive) {
        this.drive = drive;
        init();
    }

    public void init() {
        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        drive.setMotorPowers(0, 0, 0, 0);
    }

    @Override
    public void periodic() {
        drive.update();
    }

    public void drive(Pose2d drivePower) {
        drive.setWeightedDrivePower(drivePower);
    }

}
