package cl.cooperativa.readxmlfrominternetmaterial.model;

import java.io.Serializable;

/**
 * Created by innova6 on 02-06-2017.
 */

public class ArticleDetail implements Serializable {

    private String titleDetail,contDetail,imageUrlDetail;

    public ArticleDetail() {
    }

    public ArticleDetail(String titleDetail, String contDetail, String imageUrlDetail) {
        this.titleDetail = titleDetail;
        this.contDetail = contDetail;
        this.imageUrlDetail = imageUrlDetail;
    }


    public String getTitleDetail() {
        System.out.println("Article Detail, titleDetail: "+titleDetail);
        return titleDetail;
    }

    public void setTitleDetail(String titleDetail) {
        this.titleDetail = titleDetail;
    }

    public String getContDetail() {
        return contDetail;
    }

    public void setContDetail(String contDetail) {
        this.contDetail = contDetail;
    }

    public String getImageUrlDetail() {
        return imageUrlDetail;
    }

    public void setImageUrlDetail(String imageUrlDetail) {
        this.imageUrlDetail = imageUrlDetail;
    }


}