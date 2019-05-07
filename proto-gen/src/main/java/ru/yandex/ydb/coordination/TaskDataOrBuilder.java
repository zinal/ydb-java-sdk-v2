// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: kikimr/public/api/protos/ydb_coordination.proto

package ru.yandex.ydb.coordination;

public interface TaskDataOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Ydb.Coordination.TaskData)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * User-defined type of the task
   * </pre>
   *
   * <code>string task_type = 1;</code>
   */
  java.lang.String getTaskType();
  /**
   * <pre>
   * User-defined type of the task
   * </pre>
   *
   * <code>string task_type = 1;</code>
   */
  com.google.protobuf.ByteString
      getTaskTypeBytes();

  /**
   * <pre>
   * Binary data needed for task execution
   * </pre>
   *
   * <code>bytes payload = 2;</code>
   */
  com.google.protobuf.ByteString getPayload();

  /**
   * <pre>
   * Group used for scheduling jobs
   * </pre>
   *
   * <code>bytes group = 3;</code>
   */
  com.google.protobuf.ByteString getGroup();

  /**
   * <pre>
   * Number of parallel jobs for the task
   * </pre>
   *
   * <code>uint32 count = 4;</code>
   */
  int getCount();

  /**
   * <pre>
   * Resources required for completing the task
   * </pre>
   *
   * <code>repeated .Ydb.Coordination.Resource resources = 5;</code>
   */
  java.util.List<ru.yandex.ydb.coordination.Resource> 
      getResourcesList();
  /**
   * <pre>
   * Resources required for completing the task
   * </pre>
   *
   * <code>repeated .Ydb.Coordination.Resource resources = 5;</code>
   */
  ru.yandex.ydb.coordination.Resource getResources(int index);
  /**
   * <pre>
   * Resources required for completing the task
   * </pre>
   *
   * <code>repeated .Ydb.Coordination.Resource resources = 5;</code>
   */
  int getResourcesCount();
  /**
   * <pre>
   * Resources required for completing the task
   * </pre>
   *
   * <code>repeated .Ydb.Coordination.Resource resources = 5;</code>
   */
  java.util.List<? extends ru.yandex.ydb.coordination.ResourceOrBuilder> 
      getResourcesOrBuilderList();
  /**
   * <pre>
   * Resources required for completing the task
   * </pre>
   *
   * <code>repeated .Ydb.Coordination.Resource resources = 5;</code>
   */
  ru.yandex.ydb.coordination.ResourceOrBuilder getResourcesOrBuilder(
      int index);
}