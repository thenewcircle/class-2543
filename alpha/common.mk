# Since this file can also be referenced by alpha-sdk_addon 
# we cannot assume LOCAL_PATH points to the directory where
# this file is located. Instead, we create another variable
# to capture this directory.
MY_PATH := $(LOCAL_PATH)/../alpha

# Include all makefiles in sub-directories (one level deep)
include $(call all-subdir-makefiles)

# Enable our custom kernel
LOCAL_KERNEL := $(MY_PATH)/kernel
PRODUCT_COPY_FILES += $(LOCAL_KERNEL):kernel

# Copy our init and ueventd configuration files to the root
# file system (ramdisk.img -> boot.img)
PRODUCT_COPY_FILES += $(MY_PATH)/init.marakanaalphaboard.rc:root/init.marakanaalphaboard.rc
PRODUCT_COPY_FILES += $(MY_PATH)/ueventd.marakanaalphaboard.rc:root/ueventd.marakanaalphaboard.rc

# Add these packages to this product
PRODUCT_PACKAGES += libmrknlog
PRODUCT_PACKAGES += mrknlog
PRODUCT_PACKAGES += mrknlogd

PRODUCT_PACKAGES += \
	com.marakana.android.lib.log \
	com.marakana.android.lib.log.xml \
	libmrknlog_jni

PRODUCT_PACKAGES += \
	com.marakana.android.service.log \
	com.marakana.android.service.log.xml

PRODUCT_PACKAGES += MrknLogService

# Intel Changes
PRODUCT_PACKAGES += libloglib
