package pers.hongdenglv.work13;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-03-03 15:17
 */
public class ReadSql {
    private String path;
    private List<String> sqlList = new ArrayList<>();

    public ReadSql(String path) throws IOException {
        this.path = path;
        this.readFile();
    }

    private void readFile() throws IOException {
        File file = new File(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String sql;
        while ((sql = bufferedReader.readLine()) != null) {
            sqlList.add(sql);
        }
    }

    public List<String> getSqlList() {
        return sqlList;
    }
}
