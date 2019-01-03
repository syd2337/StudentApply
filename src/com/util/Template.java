package com.util;

import java.util.List;

/**
 * @author syd2018-9-18����10:01:36
 * @version ����ʱ�䣺2018-9-18 ����10:01:36
 * ��˵��
 */
/**        
 * �����ƣ�Template   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-9-18 ����10:01:36      
 * @version    
 *    
 */
public class Template {
	// ��Ϣ���շ�
		private String toUser;
		// ģ��id
		private String templateId;
		// form_id
		private String formId;
		// ģ����Ϣ��������
		private String url;
		// ��Ϣ��������ɫ
		private String topColor;
		// �����б�
		private List<TemplateParam> templateParamList;

		public String getToUser() {
			return toUser;
		}

		public void setToUser(String toUser) {
			this.toUser = toUser;
		}

		public String getTemplateId() {
			return templateId;
		}

		public void setTemplateId(String templateId) {
			this.templateId = templateId;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getTopColor() {
			return topColor;
		}

		public void setTopColor(String topColor) {
			this.topColor = topColor;
		}

		public String toJSON() {
			StringBuffer buffer = new StringBuffer();
			buffer.append("{");
			buffer.append(String.format("\"touser\":\"%s\"", this.toUser)).append(
					",");
			buffer.append(String.format("\"template_id\":\"%s\"", this.templateId))
					.append(",");
			buffer.append(String.format("\"form_id\":\"%s\"", this.formId))
					.append(",");
			buffer.append(String.format("\"url\":\"%s\"", this.url)).append(",");
			buffer.append(String.format("\"topcolor\":\"%s\"", this.topColor))
					.append(",");
			buffer.append("\"data\":{");
			TemplateParam param = null;
			if (this.templateParamList.size() > 0) {
				for (int i = 0; i < this.templateParamList.size(); i++) {
					param = templateParamList.get(i);
					// �ж��Ƿ�׷�Ӷ���
					if (i < this.templateParamList.size() - 1) {

						buffer.append(String.format(
								"\"%s\": {\"value\":\"%s\",\"color\":\"%s\"},",
								param.getName(), param.getValue(), param.getColor()));
					} else {
						buffer.append(String.format(
								"\"%s\": {\"value\":\"%s\",\"color\":\"%s\"}",
								param.getName(), param.getValue(), param.getColor()));
					}

				}
			}
			buffer.append("}");
			buffer.append("}");
			return buffer.toString();
		}

		public List<TemplateParam> getTemplateParamList() {
			return templateParamList;
		}

		public void setTemplateParamList(List<TemplateParam> templateParamList) {
			this.templateParamList = templateParamList;
		}

		public String getFormId() {
			return formId;
		}

		public void setFormId(String formId) {
			this.formId = formId;
		}
}
