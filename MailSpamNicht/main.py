import smtplib
import google.auth
from google.auth.transport.requests import Request
from google.oauth2 import service_account

# Load the credentials from a JSON service account key file
credentials = service_account.Credentials.from_service_account_file('path/to/service_account_key.json',
                                                                     scopes=['https://www.googleapis.com/auth/gmail.send'])

# Check if the credentials are expired and refresh them if necessary
if credentials.expired:
    credentials.refresh(Request())

# Create an authorized SMTP connection using the credentials
smtp_server = smtplib.SMTP('smtp.gmail.com', 587)
smtp_server.ehlo()
smtp_server.starttls(context=credentials)
smtp_server.ehlo()
smtp_server.login(smtp_server.auth_user, smtp_server.auth_password)

# Send the email
from_email = "mailman319@gmail.com"
to_email = "jukuhmu@gmail.com"
message = "Test"

smtp_server.sendmail(from_email, to_email, message)

# Close the connection
smtp_server.quit()
