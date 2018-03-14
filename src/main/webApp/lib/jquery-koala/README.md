jquery-koala
============

Koala is a jQuery plugin that capture user's continuous input and execute callbacks of keyboard events delayed.

## Usage

Load jQuery and koala:

```html
<script src="jquery.min.js" type="text/javascript"></script>
<script src="jquery.koala.js" type="text/javascript"></script>
```

Bind keyboard events to the dom with Koala.

```html
<script type="text/javascript">
   jQuery(document).ready(function() {
    $('.koala').koala({
      delay: 200,
      keyup: function(event){
        // do anything you want
        // ex. ajax
      }
    });
   });
</script>
```

Koala support descendant elements that are added to the document at a later time.

```html
<script type="text/javascript">
   jQuery(document).ready(function() {
    $("#future").koala('.koala', {
      delay: 300,
      keyup: function(event){
        // do anything you want
        // ex. ajax
      }
    });
   });
</script>
```

### Example

Check the [index.html](https://github.com/kenshin54/jquery-koala/blob/master/index.html)

### Naming

Because koala is lazy. :)

## Contributing

1. Fork it
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create new Pull Request
