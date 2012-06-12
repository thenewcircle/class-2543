#include "com_intel_lognative_LogLib.h"

void JNICALL Java_com_intel_lognative_LogLib_log
  (JNIEnv *env, jclass clazz, jint priority, jstring tag, jstring message) {

	// Convert jstring to char*
	const char *c_tag = (*env)->GetStringUTFChars(env, tag, 0);
	const char *c_message = (*env)->GetStringUTFChars(env, message, 0);

	// Call the log write function
	__android_log_write(priority, c_tag, c_message);

	// Release char*
	(*env)->ReleaseStringUTFChars(env, tag, c_tag);
	(*env)->ReleaseStringUTFChars(env, message, c_message);
}
