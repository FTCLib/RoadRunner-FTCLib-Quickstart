package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;

public class TurnCommand extends CommandBase {

    private final MecanumDriveSubsystem drive;
    private final double angle;

    public TurnCommand(MecanumDriveSubsystem drive, double angle) {
        this.drive = drive;
        this.angle = angle;
        
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        drive.turn(angle);
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
