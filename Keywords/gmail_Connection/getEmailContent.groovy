package gmail_Connection

import javax.mail.Folder
import javax.mail.Message
import javax.mail.MessagingException
import javax.mail.NoSuchProviderException
import javax.mail.Session
import javax.mail.Store
import javax.mail.Message.RecipientType
import javax.mail.search.AndTerm
import javax.mail.search.RecipientStringTerm
import javax.mail.search.SearchTerm
import javax.mail.search.SubjectTerm

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class getEmailContent {


	@Keyword
	def findConfirmEmailURL(String QAEmail, String QAPassword, String EmailRecipient) throws MessagingException {

		SearchTerm filter = createFilter(EmailRecipient)					            	// 1. Create mail search filter for our mailbox
		Store store = connect(QAEmail, QAPassword)								            // 2. Connect to our mailbox
		String content = getMessageContent(store, filter)		                            // 3. Retrieve the message body from the received email
		String url = getURL(content)						                            	// 4. Get the confirmation URL from the message body
		return url
	}


	private SearchTerm createFilter(String Recipient){
		SearchTerm term1 = new RecipientStringTerm(RecipientType.TO, Recipient)
		SearchTerm term2 = new SubjectTerm(GlobalVariable.G_EmailSubject_Registration)
		SearchTerm searchTerm = new AndTerm(term1, term2)
		return searchTerm;
	}


	// Make connection with Gmail Account
	private Store connect(String QAEmail, String QAPassword) throws MessagingException {

		Properties props = new Properties()
		props.setProperty("mail.store.protocol", "imaps")
		Session session = Session.getDefaultInstance(props, null)
		Store store;

		try{

			store = session.getStore("imaps")
			store.connect("imap.gmail.com", QAEmail, QAPassword)

		} catch (Exception e) {

			e.printStackTrace()
			throw e
		}

		return store
	}


	// Get Message from Gmail Account.
	public String getMessageContent(Store store, SearchTerm filter) throws MessagingException {

		String mailMessageContent = ""

		try{
			// Specify folder/label
			Folder emailFolder = store.getFolder("VV")
			emailFolder.open(Folder.READ_ONLY)

			// Apply filter and get messages
			Message[] messages = emailFolder.search(filter)
			int messagesLength = messages.length

			if(messages.length != 0){

				// Get last message (content of the last email received)
				Message message = messages[messagesLength - 1]

				String subject = message.getSubject();
				String from = message.getFrom()[].toString();
				String content = message.getContent().toString();

				mailMessageContent = content;
			}

			emailFolder.close(false)
		} catch (Exception e) {

			e.printStackTrace()
		} finally {

			store.close()
		}

		return mailMessageContent;
	}


	// Obtain the link from the message
	private String getURL(String content){
		Document doc = Jsoup.parse(content)
		Element element = doc.getElementsByAttributeValueContaining("href", "visualvault.com")[0]
		return element.attr("href")
	}
}