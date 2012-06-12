LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_SRC_FILES := loglib.c
LOCAL_MODULE := loglib
LOCAL_LDLIBS += -llog
include $(BUILD_SHARED_LIBRARY)