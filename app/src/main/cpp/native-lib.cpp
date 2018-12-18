#include <jni.h>
#include <string>
#include <cinttypes>

extern "C" uint64_t IMEI_Generate_Random();

extern "C"
JNIEXPORT jstring JNICALL
Java_com_reimunotmoe_imeigenerator_MainActivity_GenerateIMEI(JNIEnv *env, jobject instance) {

    char buf[24] = {0};
    snprintf(buf, 16, "%015" PRIu64, IMEI_Generate_Random());

    return env->NewStringUTF(buf);
}