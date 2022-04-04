#!/usr/bin/env python
# coding: utf-8

# In[16]:


import pandas as pd
import numpy as np 


# In[17]:


artist_f = "artist.csv"


# In[18]:


artists = pd.read_csv(artist_f, dtype='unicode')
artists.head()


# In[19]:


artists.shape


# In[20]:


artists.columns


# In[21]:


new = artists[['rdf-schema#label', 'birthDate', 'birthPlace_label', 'deathDate', 'field_label', 'genre_label', 'instrument_label', 'nationality_label', 'thumbnail', 'wikiPageID', 'description']]


# In[22]:


new.head()


# In[23]:


new.shape


# In[24]:


artist = new.drop([0,1,2]).reset_index(drop=True)


# In[25]:


artist.to_csv('Book1.csv', index=False)
artist


# In[26]:


artist = artist.rename(columns={'rdf-schema#label':'personName'})
artist


# In[27]:


artist['birthPlace_label'] = artist['birthPlace_label'].str.replace("[{}]", "")
artist['birthPlace_label'] = artist['birthPlace_label'].str.replace("[|]", ",")
artist


# In[28]:


artist['field_label'] = artist['field_label'].str.replace("[{}]", "")
artist['field_label'] = artist['field_label'].str.replace("[|]", ",")
artist['genre_label'] = artist['genre_label'].str.replace("[{}]", "")
artist['genre_label'] = artist['genre_label'].str.replace("[|]", ",")
artist['instrument_label'] = artist['instrument_label'].str.replace("[{}]", "")
artist['instrument_label'] = artist['instrument_label'].str.replace("[|]", ",")
artist


# In[29]:


artist.to_csv('new_artists_copy.csv', index=False)


# In[30]:


artist.to_csv('indx_artists_new.csv', header=False, index=True)


# In[ ]:




