package za.co.bbd.momentum.journalrest.api.model.request.response;

public class JournalCountResponse {

    private Long count;

    public JournalCountResponse(Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
