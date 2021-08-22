package com.shhatrat.base.presenter

enum class VisibilityState {
    FOREGROUND, BACKGROUND
}

enum class ComponentType {
    ACTIVITY, FRAGMENT
}

sealed class PresenterState(
    open val componentType: ComponentType,
    visibilityState: VisibilityState
) {

    class OnCreate(override val componentType: ComponentType) :
        PresenterState(componentType, VisibilityState.FOREGROUND)

    class OnStart(override val componentType: ComponentType) :
        PresenterState(componentType, VisibilityState.FOREGROUND)

    class OnResume(override val componentType: ComponentType) :
        PresenterState(componentType, VisibilityState.FOREGROUND)

    class OnPause(override val componentType: ComponentType) :
        PresenterState(componentType, VisibilityState.BACKGROUND)

    class OnStop(override val componentType: ComponentType) :
        PresenterState(componentType, VisibilityState.BACKGROUND)

    class OnDestroy(override val componentType: ComponentType) :
        PresenterState(componentType, VisibilityState.BACKGROUND)
}

fun dd(ddd: PresenterState) {
    when (ddd) {
        is PresenterState.OnCreate -> TODO()
        is PresenterState.OnDestroy -> TODO()
        is PresenterState.OnPause -> TODO()
        is PresenterState.OnResume -> TODO()
        is PresenterState.OnStart -> TODO()
        is PresenterState.OnStop -> TODO()
    }
}