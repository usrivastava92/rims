package com.app.core.json.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.joda.cfg.FormatConfig;
import com.fasterxml.jackson.datatype.joda.cfg.JacksonJodaDateFormat;
import com.fasterxml.jackson.datatype.joda.ser.JodaDateSerializerBase;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class DateTimeCustomSerializer
        extends JodaDateSerializerBase<DateTime> {
    private static final long serialVersionUID = 2L;

    public DateTimeCustomSerializer() {
        this(FormatConfig.DEFAULT_DATETIME_PRINTER);
    }


    public DateTimeCustomSerializer(JacksonJodaDateFormat format) {
        super(DateTime.class, format, false, SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }


    public DateTimeCustomSerializer withFormat(JacksonJodaDateFormat formatter) {
        return (this._format == formatter) ? this : new DateTimeCustomSerializer(formatter);
    }


    public void serialize(DateTime dateTime, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException, JsonGenerationException {
        if (_useTimestamp(provider)) {
            jsonGenerator.writeNumber(dateTime.getMillis());
        } else {
            DateFormat dateFormat = provider.getConfig().getDateFormat();

            DateTimeFormatter formatter = null;
            if (dateFormat != null && SimpleDateFormat.class
                    .isAssignableFrom(dateFormat
                            .getClass())) {

                SimpleDateFormat simpleDateFormat = (SimpleDateFormat) provider.getConfig().getDateFormat();


                formatter = DateTimeFormat.forPattern(simpleDateFormat.toPattern()).withLocale(Locale.ROOT).withChronology(ISOChronology.getInstanceUTC());
            } else {
                formatter = DateTimeFormat.fullDateTime();
            }

            jsonGenerator.writeString(dateTime.toString(formatter));
        }
    }

}



