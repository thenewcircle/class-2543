LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE_TAGS := optional
LOCAL_SRC_FILES := loglib.c
LOCAL_MODULE := loglib
#LOCAL_LDLIBS += -llog
LOCAL_SHARED_LIBRARIES := libcutils 
include $(BUILD_SHARED_LIBRARY)