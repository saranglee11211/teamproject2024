import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.teamproject2024.R

class MainActivity : AppCompatActivity() {

    private lateinit var textViewTotalAmount: TextView
    private lateinit var textViewGoalLeft: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var buttonAdd: Button
    private lateinit var buttonReset: Button
    private lateinit var viewPager: ViewPager2

    private var currentAmount = 500  // 초기값 500ml
    private val maxAmount = 1000  // 최대 1000ml

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // XML에서 뷰를 찾아와서 참조 연결
        textViewTotalAmount = findViewById(R.id.textView_totalAmount)
        textViewGoalLeft = findViewById(R.id.textView_goalLeft)
        progressBar = findViewById(R.id.progressBar)
        buttonAdd = findViewById(R.id.button_add)
        buttonReset = findViewById(R.id.button_reset)

        // 초기 UI 설정
        updateUI()

        // 추가하기 버튼 클릭 시
        buttonAdd.setOnClickListener {
            addAmount(100)  // 100ml 추가
        }

        // 삭제하기 버튼 클릭 시
        buttonReset.setOnClickListener {
            resetAmount()  // 0ml로 초기화
        }

    }

    // UI 업데이트 함수 (TextView 및 ProgressBar를 동기화)
    private fun updateUI() {
        // 총 마신 양 업데이트
        textViewTotalAmount.text = "음료수를\n총 ${currentAmount}ml\n마셨어요!"

        // 목표까지 남은 양 업데이트 (1000ml 기준)
        val remainingAmount = maxAmount - currentAmount
        textViewGoalLeft.text = "목표 음수량 도달까지 ${remainingAmount}ml 남았어요!"

        // ProgressBar 업데이트
        progressBar.progress = (currentAmount.toFloat() / maxAmount * 100).toInt()  // 퍼센트 계산
    }

    // 물 추가 함수
    private fun addAmount(amount: Int) {
        if (currentAmount + amount <= maxAmount) {
            currentAmount += amount
            updateUI()  // UI 업데이트
        }
    }

    // 리셋 함수
    private fun resetAmount() {
        currentAmount = 0
        updateUI()  // UI 업데이트
    }

}
