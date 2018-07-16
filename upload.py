
# coding: utf-8

# In[1]:


import gspread
import sys


# In[16]:


from oauth2client.service_account import ServiceAccountCredentials

scope = ['https://spreadsheets.google.com/feeds',
        'https://www.googleapis.com/auth/drive']

credentials = ServiceAccountCredentials.from_json_keyfile_name('client_secret.json', scope)

gc = gspread.authorize(credentials)


# In[ ]:


Id = sys.argv[1]
status = sys.argv[2]
sheettitle = sys.argv[3]


# In[ ]:


sheet = gc.open("Sheet automate").worksheet(sheettitle)


# In[25]:


row = sheet.find(Id).row


# In[7]:


sheet.update_cell(row,2,status)

