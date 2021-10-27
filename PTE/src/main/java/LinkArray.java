import java.util.ArrayList;
import java.util.Date;

public class LinkArray {

    private String url;
    private final Date data;

    public LinkArray(String url, Date data) {
        this.url = url;
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public Date getData() {
        return data;
    }

    public void Time() {
        Date data = new Date(System.currentTimeMillis());
    }

    ArrayList Links = new ArrayList();

    public void AggiungiLink() {
        Links.forEach(() -> {
            Links.add();
        });
    }

    public void Ordinamento() {
        for(int i = 0; i < Links.size(); i++) {
            int x = i;
            for(int j = i-1; j >= 0; j++) {
                if(((String) Links.get(j)).charAt(0) > ((String) Links.get(x)).charAt(0)) {
                    int k = (int) Links.get(x);
                    Links.set(x, Links.get(j));
                    Links.set(j, k);
                    x = j;
                }else break;
            }
        }
    }

}
