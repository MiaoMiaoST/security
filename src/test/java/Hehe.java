import com.boot.DemoApplication;
import com.boot.dao.SysUserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Date:2017/2/28 16:21
 * <p>
 * Author:zgj
 * <p>
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=DemoApplication.class)// 指定spring-boot的启动类
public class Hehe {
    @Autowired
    private SysUserDao sysUserDao;

    @Test
    public void te(){
        System.out.println(sysUserDao.findByUsername("root").getAuthorities().toString());
    }
}
