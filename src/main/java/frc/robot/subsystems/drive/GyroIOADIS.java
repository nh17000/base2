// Copyright (c) 2021-2026 Littleton Robotics
// http://github.com/Mechanical-Advantage
//
// Use of this source code is governed by a BSD
// license that can be found in the LICENSE file
// at the root directory of this project.

package frc.robot.subsystems.drive;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.ADIS16470_IMU;

/** IO implementation for Pigeon 2. */
public class GyroIOADIS implements GyroIO {
  private final ADIS16470_IMU adis;
  // private final Pigeon2 pigeon = new Pigeon2(pigeonCanId);
  // private final StatusSignal<Angle> yaw = pigeon.getYaw();
  // private final Queue<Double> yawPositionQueue;
  // private final Queue<Double> yawTimestampQueue;
  // private final StatusSignal<AngularVelocity> yawVelocity = pigeon.getAngularVelocityZWorld();

  public GyroIOADIS() {

    adis = new ADIS16470_IMU();
    // adis.setGyroAngleX(0);
    // adis.setGyroAngleY(0);
    // adis.setGyroAngleZ(0);
    // pigeon.getConfigurator().apply(new Pigeon2Configuration());
    // pigeon.getConfigurator().setYaw(0.0);
    // yaw.setUpdateFrequency(odometryFrequency);
    // yawVelocity.setUpdateFrequency(50.0);
    // pigeon.optimizeBusUtilization();
    // yawTimestampQueue = SparkOdometryThread.getInstance().makeTimestampQueue();
    // var yawClone = yaw.clone(); // Status signals are not thread-safe
    // yawPositionQueue =
    //     SparkOdometryThread.getInstance()
    //         .registerSignal(() -> yawClone.refresh().getValueAsDouble());
  }

  @Override
  public void updateInputs(GyroIOInputs inputs) {
    inputs.connected = adis.isConnected();
    inputs.yawPosition = Rotation2d.fromDegrees(adis.getAngle());
    inputs.yawVelocityRadPerSec = Units.degreesToRadians(adis.getRate());

    // inputs.connected = BaseStatusSignal.refreshAll(yaw, yawVelocity).equals(StatusCode.OK);
    // inputs.yawPosition = Rotation2d.fromDegrees(yaw.getValueAsDouble());
    // inputs.yawVelocityRadPerSec = Units.degreesToRadians(yawVelocity.getValueAsDouble());

    // inputs.odometryYawTimestamps =
    //     yawTimestampQueue.stream().mapToDouble((Double value) -> value).toArray();
    // inputs.odometryYawPositions =
    //     yawPositionQueue.stream()
    //         .map((Double value) -> Rotation2d.fromDegrees(value))
    //         .toArray(Rotation2d[]::new);
    // yawTimestampQueue.clear();
    // yawPositionQueue.clear();
  }
}
