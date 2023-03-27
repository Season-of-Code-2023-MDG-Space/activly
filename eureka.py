# -*- coding: utf-8 -*-
"""
Created on Tue Mar 28 01:21:15 2023

@author: jains
"""

from flask import Flask
from flask_restful import Resource, Api
from flask import request, jsonify

import nltk 
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize, sent_tokenize

app = Flask(__name__)
api = Api(app)


def club_name_extracter(text):
    clubs=["PAG","SDS","MDG"]
    no_of_words = text.split(' ')

    if len(no_of_words)<= 15:
        print(len(no_of_words))
        return

    words = nltk.word_tokenize(text)
    words = [word for word in words if word not in set(stopwords.words('english'))]
    tagged = nltk.pos_tag(words)

    for (word, tag) in tagged:

        if tag == 'NNP':
            if word in clubs:
                print(text)
                return text



class HelloWorld(Resource):
    def get(self ):
        data = request.get_json()
        name = data['message']
        t=club_name_extracter(name)

        return t



api.add_resource(HelloWorld, '/')

if __name__ == '__main__':
    app.run(debug=True)