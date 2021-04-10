#include <jni.h>
#include <string>
#include <jni.h>

extern "C" JNIEXPORT jstring JNICALL
Java_com_shhatrat_cpp_HelloWorld_stringFromJNI(JNIEnv *env, jobject thiz) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}