`최근 업데이트 : '22. 09. 15.`

![image](https://user-images.githubusercontent.com/86638578/183851710-91769369-8591-4ce4-b6d8-f057530005aa.png)
## 개요
#### ✔ 참고 자료를 바탕으로 작성했으나 일부 수정 및 삭제한 내용이 있습니다.
#### ✔ 다음 [자료](https://todaycode.tistory.com/49)를 참고하여 구현했으며, 지속적으로 업데이트 될 예정입니다.
#### ✔ 이외에도 [Clean Architecture Repo](https://github.com/woongcheol/Android-Clean-Architecture)에서 다양한 개념들을 확인하실 수 있습니다.  
#### ✔ 오류 및 보완해야할 내용은 Contribution을 통해 기여부탁드리겠습니다🙇‍♂️

</br>

## 본론  
### 1. Android LiveData란?

- 데이터를 담을 수 있는 Data Holder 클래스입니다. 만약 특정 변수의 데이터의 변경을 확인하고 싶을 때 MutableLiveData에 해당 변수를 저장합니다.

- 데이터는 Observer에서 관찰합니다. 관찰은 주어진 Life Cycle 내에서만 가능하며 이러한 관찰은 MutableLiveData가 아닌 LiveData에 담겨진 데이터만 관찰할 수 있습니다.

- 관찰된 데이터에 변경이 일어나면 UI 컨트롤러(Activity)에 전달되고 이를 통해 UI 컨트롤러는 UI를 업데이트 합니다.

### 2. Life Cycle이란?

- LiveDate는 lifecycle-aware component 입니다. Life Cycle에 영향을 받으며 observer가 위치한 View가 사라지면 LiveData도 사라지게 됩니다.

- Activity나 Fragment 같은 컴포넌트의 생명 주기 상태에 대한 정보를 다른 객체가 이를 관찰하도록 지원하는 클래스입니다.

- 이를 통해 라이프 사이클을 고려할 수 있어 메모리 leak과 앱 crash를 방지할 수 있습니다.

- LifecycleOwner는 Activity 객체를 의미하며, 내부에 있는 Lifecycle 객체에 액티비티 상태를 제공합니다.

- LifecycleObserver는 Lifecycle로부터 Activity 상태변화에 대한 이벤트를 받습니다.

### 3. LiveData와 MutableLiveData에 대한 차이
- MutableLiveData는 추상 클래스인 LiveData를 상속받은 클래스입니다.

- 추상 클래스인 LiveData를 생성할 수 없기 때문에 MutablLiveData로 구현하여 setValue / postValue을 통해 데이터를 입출력해야합니다.

#### MutableLiveData
```java
public class MutableLiveData<T> extends LiveData<T> {

    public MutableLiveData(T value) {
        super(value);
    }

    public MutableLiveData() {
        super();
    }

    @Override
    public void postValue(T value) {
        super.postValue(value);
    }

    @Override
    public void setValue(T value) {
        super.setValue(value);
    }
}
```
