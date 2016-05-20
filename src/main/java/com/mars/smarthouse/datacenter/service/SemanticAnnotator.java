package com.mars.smarthouse.datacenter.service;

import com.mars.smarthouse.constant.Lexicon;

/**
 * Created by Administrator on 2016/5/9.
 */
public class SemanticAnnotator {
	public String TemperatureAnnotator(String rank) {
		return rank.equals(Lexicon.veryLow) ? Lexicon.freezing : rank.equals(Lexicon.low) ?
				Lexicon.cold : rank.equals(Lexicon.moderation) ? Lexicon.normal :
				rank.equals(Lexicon.high) ? Lexicon.burning : Lexicon.very_burning;
	}

	public String HumidityAnnotator(String rank) {
		return rank.equals(Lexicon.veryLow) ? Lexicon.very_dry : rank.equals(Lexicon.low) ?
				Lexicon.dry : rank.equals(Lexicon.moderation) ? Lexicon.normal :
				rank.equals(Lexicon.high) ? Lexicon.moist : Lexicon.very_moist;
	}

	public String LightAnnotator(String rank) {
		return rank.equals(Lexicon.veryLow) ? Lexicon.dark : rank.equals(Lexicon.low) ?
				Lexicon.dim : rank.equals(Lexicon.moderation) ? Lexicon.normal :
				rank.equals(Lexicon.glare) ? Lexicon.burning : Lexicon.very_glare;
	}

	public String VocAnnotator(String rank) {
		return rank.equals(Lexicon.veryLow) || rank.equals(Lexicon.low) ? Lexicon.low : rank.equals(Lexicon.moderation) ?
				Lexicon.high : Lexicon.veryHigh;
	}

	public String PM25Annotator(String rank) {
		return rank.equals(Lexicon.veryLow) || rank.equals(Lexicon.low) ? Lexicon.low : rank.equals(Lexicon.moderation) ?
				Lexicon.high : Lexicon.veryHigh;
	}

	public String nowTimeFrameAnnotator() {

//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date now=df.format(new Date());
//        try {
//            Date date=df.parse("2000-01-02 10:00:00");
//            int difference=
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
		return null;

	}
}
