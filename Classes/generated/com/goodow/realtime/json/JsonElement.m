//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: /Users/retechretech/dev/workspace/realtime/realtime-json/src/main/java/com/goodow/realtime/json/JsonElement.java
//
//  Created by retechretech.
//

#include "com/goodow/realtime/json/JsonArray.h"
#include "com/goodow/realtime/json/JsonElement.h"
#include "com/goodow/realtime/json/JsonObject.h"


@interface GDJsonElement : NSObject
@end

@implementation GDJsonElement

+ (J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { "asArray", NULL, "LGDJsonArray", 0x401, NULL },
    { "asObject", NULL, "LGDJsonObject", 0x401, NULL },
    { "isArray", NULL, "Z", 0x401, NULL },
    { "isObject", NULL, "Z", 0x401, NULL },
    { "toJsonString", NULL, "LNSString", 0x401, NULL },
  };
  static J2ObjcClassInfo _GDJsonElement = { "JsonElement", "com.goodow.realtime.json", NULL, 0x201, 5, methods, 0, NULL, 0, NULL};
  return &_GDJsonElement;
}

@end