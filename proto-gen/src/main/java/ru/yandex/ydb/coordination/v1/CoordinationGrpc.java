// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: kikimr/public/api/grpc/ydb_coordination_v1.proto

package ru.yandex.ydb.coordination.v1;

public final class CoordinationGrpc {
  private CoordinationGrpc() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n0kikimr/public/api/grpc/ydb_coordinatio" +
      "n_v1.proto\022\023Ydb.Coordination.V1\032/kikimr/" +
      "public/api/protos/ydb_coordination.proto" +
      "2\312\003\n\023CoordinationService\022R\n\007Session\022 .Yd" +
      "b.Coordination.SessionRequest\032!.Ydb.Coor" +
      "dination.SessionResponse(\0010\001\022W\n\nCreateNo" +
      "de\022#.Ydb.Coordination.CreateNodeRequest\032" +
      "$.Ydb.Coordination.CreateNodeResponse\022T\n" +
      "\tAlterNode\022\".Ydb.Coordination.AlterNodeR" +
      "equest\032#.Ydb.Coordination.AlterNodeRespo",
      "nse\022Q\n\010DropNode\022!.Ydb.Coordination.DropN" +
      "odeRequest\032\".Ydb.Coordination.DropNodeRe" +
      "sponse\022]\n\014DescribeNode\022%.Ydb.Coordinatio" +
      "n.DescribeNodeRequest\032&.Ydb.Coordination" +
      ".DescribeNodeResponseB3\n\035ru.yandex.ydb.c" +
      "oordination.v1B\020CoordinationGrpcP\001b\006prot" +
      "o3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          ru.yandex.ydb.coordination.CoordinationProtos.getDescriptor(),
        }, assigner);
    ru.yandex.ydb.coordination.CoordinationProtos.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}