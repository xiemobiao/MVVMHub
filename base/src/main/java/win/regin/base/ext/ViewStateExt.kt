package win.regin.base.ext

import androidx.lifecycle.MutableLiveData
import win.regin.base.constant.HubConstant
import win.regin.common.BaseEntity
import win.regin.base.exception.AppException
import win.regin.base.state.ViewState

/**
 * @author :Reginer in  2019/7/8 10:47.
 *         联系方式:QQ:282921012
 *         功能描述:
 */

/**
 * 处理返回值
 *
 * @param result 请求结果
 */
fun <T> MutableLiveData<ViewState<T>>.paresResult(result: BaseEntity<T>) {
    value = if (result.errorCode == HubConstant.REQUEST_RESULT_SUCCESS) {
        ViewState.onAppSuccess(result.data)
    } else {
        ViewState.onAppError(AppException(result.errorMsg))
    }
}

/**
 * 异常转换异常处理
 */
fun <T> MutableLiveData<ViewState<T>>.paresException(e: Throwable) {
    this.value = ViewState.onAppError(AppException(e))
}