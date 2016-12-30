package cn.cnu.songpoemcreate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;

    String[] words = new String[]{"东风", "何处", "人间", "风流", "归去", "春风", "西风", "归来",
            "江南", "相思", "梅花", "千里", "回首", "明月", "多少", "如今", "阑干", "年年", "万里",
            "一笑", "黄昏", "当年", "天涯", "相逢", "芳草", "尊前", "一枝", "风雨", "流水", "依旧",
            "风吹", "风月", "多情", "故人", "当时", "无人", "斜阳", "不知", "不见", "深处", "时节",
            "平生", "凄凉", "春色", "匆匆", "功名", "一点", "无限", "今日", "天上", "杨柳", "西湖",
            "桃花", "扁舟", "消息", "憔悴", "何事", "芙蓉", "神仙", "一片", "桃李", "人生", "十分",
            "心事", "黄花", "一声", "佳人", "长安", "东君", "断肠", "而今", "鸳鸯", "为谁", "十年",
            "去年", "少年", "海棠", "寂寞", "无情", "不是", "时候", "肠断", "富贵", "蓬莱", "昨夜",
            "行人", "今夜", "谁知", "不似", "江上", "悠悠", "几度", "青山", "何时", "天气", "惟有",
            "一曲", "月明", "往事", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView2);
        editText = (EditText) findViewById(R.id.editText);
    }

    public void create(View v) {
        String telephoneNo = editText.getText().toString().trim();
        if (telephoneNo.length() != 11) {
            Toast.makeText(MainActivity.this, "请输入11位手机号", Toast.LENGTH_SHORT).show();
        } else {
            telephoneNo = telephoneNo + (int) Math.floor(Math.random() * 10);//在手机号末尾加一个随机数
            String a[] = new String[6];//两位一截取存入新数组
            for (int i = 0; i < 12; i += 2) {
                a[i / 2] = telephoneNo.charAt(i) + "" + telephoneNo.charAt(i + 1);
            }
            int b[] = new int[6];
            for (int i = 0; i < 6; i++) {
                b[i] = Integer.parseInt(a[i]);//字符串转为int
            }
            String poem = "";
            for (int i = 0; i < 6; i++) {
                if (i == 3) poem += "\n";
                poem += words[b[i]];
                textView.setText(poem);
            }
        }
    }

    public void oneCreate(View v) {
        int random[] = new int[12];
        for (int i = 0; i < 12; i++) {
            random[i] = (int) Math.floor(Math.random() * 100);
        }
        String poem = "";
        for (int i = 0; i < 12; i++) {
            if (i % 3 == 0 && i != 0) poem += "\n";
            poem += words[random[i]];
            textView.setText(poem);
        }
        System.out.println();

    }


}
