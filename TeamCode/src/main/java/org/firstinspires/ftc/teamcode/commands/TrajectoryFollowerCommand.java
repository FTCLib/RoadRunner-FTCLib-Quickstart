package org.firstinspires.ftc.teamcode.commands;

import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;

public class TrajectoryFollowerCommand extends CommandBase {

    private final MecanumDriveSubsystem drive;
    private final Trajectory trajectory;

    private boolean runOnce;

    public TrajectoryFollowerCommand(MecanumDriveSubsystem drive, Trajectory trajectory) {
        this.drive = drive;
        this.trajectory = trajectory;

        addRequirements(drive);
    }

    @Override
    public void initialize() {
        runOnce = false;
    }

    @Override
    public void execute() {
        if (!runOnce) {
            drive.followTrajectory(trajectory);
            runOnce = true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            drive.stop();
        }
    }

    @Override
    public boolean isFinished() {
        return Thread.currentThread().isInterrupted() || !drive.isBusy();
    }

}
