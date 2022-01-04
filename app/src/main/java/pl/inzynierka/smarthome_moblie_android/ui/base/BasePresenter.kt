package pl.inzynierka.smarthome_moblie_android.ui.base

abstract class BasePresenter<V : BaseContract.View> : BaseContract.Presenter<V> {

    private var view: V? = null

    override fun attachView(view: V) {
        this.view = view
    }

    override fun getView(): V {
        if (view != null) {
            return view as V
        }
        throw IllegalStateException("View has not been attached.")
    }
}