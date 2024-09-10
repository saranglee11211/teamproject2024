import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject2024.R

class ViewPagerAdapter(private val context: Context) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    // 페이지 수를 설정
    override fun getItemCount(): Int = 3  // 페이지 수를 3으로 설정 (페이지 개수에 따라 수정)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // 페이지별 레이아웃 설정
        val layoutInflater = LayoutInflater.from(context)
        val layout = when (viewType) {
            0 -> R.layout.paper_item_1  // 첫 번째 페이지 레이아웃
            1 -> R.layout.pager_item_2  // 두 번째 페이지 레이아웃
            else -> R.layout.pager_item_3  // 세 번째 페이지 레이아웃
        }
        val view = layoutInflater.inflate(layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 각 페이지 데이터 설정 (필요 시)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
